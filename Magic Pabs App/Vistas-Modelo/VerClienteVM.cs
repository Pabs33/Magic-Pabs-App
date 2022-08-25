using Magic_Pabs_App.Clases;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class VerClienteVM:ObservableObject
    {
        private Cliente cliente;

        public Cliente Cliente
        {
            get { return cliente; }
            set { SetProperty(ref cliente, value); }
        }


        public VerClienteVM(Cliente cliente)
        {
            this.Cliente = cliente;
        }
    }
}
