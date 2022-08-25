using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Servicios;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using Microsoft.Toolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class ClientesVM: ObservableObject
    {
        private ObservableCollection<Cliente> clientes;

        public ObservableCollection<Cliente> Clientes
        {
            get { return clientes; }
            set { SetProperty(ref clientes, value); }
        }

        private Cliente clienteSel;

        public Cliente ClienteSel
        {
            get { return clienteSel; }
            set { SetProperty(ref clienteSel, value); }
        }


        public RelayCommand NuevoClienteCommand { get; set; }

        public RelayCommand EditClienteCommand { get; set; }

        public ClientesVM()
        {
            this.Clientes = ServicioAPI.GetClientes();
            this.NuevoClienteCommand = new RelayCommand(NuevoCliente);
            this.EditClienteCommand = new RelayCommand(EditCliente);
            this.ClienteSel = null;
        }

        //Metodos

        public void NuevoCliente()
        {
            ServicioNavegacion.AbrirDialogoNuevoCliente();
        }

        public void EditCliente()
        {
            if(ClienteSel != null)
            {
                ServicioNavegacion.AbrirDialogoEditCliente(this.clienteSel);
            }
            else
            {
                ServicioMessageBox.MostrarMessageBox("No has seleccionado ningun cliente", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
            }
            
        }
    }
}
