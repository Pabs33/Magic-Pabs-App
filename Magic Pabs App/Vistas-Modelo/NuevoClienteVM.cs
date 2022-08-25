using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Servicios;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using Microsoft.Toolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class NuevoClienteVM:ObservableObject
    {
        public bool Edit { get; set; }

        private Cliente cliente;

        public Cliente Cliente
        {
            get { return cliente; }
            set { SetProperty(ref cliente, value); }
        }

        public bool Terminado { get; set; }

        public NuevoClienteVM()
        {
            this.Cliente = new Cliente();
            Edit = false;
            Terminado = false;
        }

        public NuevoClienteVM(Cliente cliente)
        {
            this.Cliente = cliente;
            Edit = true;
            Terminado = false;
        }

        //Metodos
        public void CrearCliente()
        {
            if(Edit && Cliente.nombre != null && Cliente.email != null && Cliente.telefono != null)
            {
                ServicioAPI.PutCliente(Cliente);
                Terminado = true;
            }
            else
            {
                if (Cliente.nombre != null && Cliente.email != null && Cliente.telefono != null)
                {
                    Cliente.idCliente = 0;
                    ServicioAPI.PostCliente(Cliente);
                    Terminado = true;
                }
                else
                {
                    ServicioMessageBox.MostrarMessageBox("Tienes que rellenar todos los campos", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
                }
            }

        }

    }
}
