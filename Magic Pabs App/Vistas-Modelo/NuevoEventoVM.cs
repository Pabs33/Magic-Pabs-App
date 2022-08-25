using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Servicios;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using Microsoft.Toolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class NuevoEventoVM:ObservableObject
    {
        private Evento eventoSel;

        public Evento EventoSel
        {
            get { return eventoSel; }
            set { SetProperty(ref eventoSel, value); }
        }

        private ObservableCollection<Cliente> listaClientes;

        public ObservableCollection<Cliente> ListaClientes
        {
            get { return listaClientes; }
            set { SetProperty(ref listaClientes, value); }
        }

        private ObservableCollection<Espectaculo> listaEspectaculos;

        public ObservableCollection<Espectaculo> ListaEspectaculos
        {
            get { return listaEspectaculos; }
            set { SetProperty(ref listaEspectaculos, value); }
        }


        public bool Edit { get; set; }

        public bool Terminado { get; set; }

        public NuevoEventoVM()
        {
            this.EventoSel = new Evento();
            this.ListaClientes = ServicioAPI.GetClientes();
            this.ListaEspectaculos = ServicioAPI.GetEspectaculos();
            Edit = false;
            Terminado = false;
        }

        public NuevoEventoVM(Evento evento)
        {
            this.EventoSel = evento;
            this.ListaClientes = ServicioAPI.GetClientes();
            this.ListaEspectaculos = ServicioAPI.GetEspectaculos();
            Edit = true;
            Terminado = false;
        }

        //metodos
        public void NuevoEvento()
        {
            if(Edit && EventoSel.direccion != null && EventoSel.fecha != null && EventoSel.tipoEvento != null && ComprobarFecha(EventoSel.fecha))
            {
                ServicioAPI.PutEvento(this.EventoSel);
                Terminado = true;
            }
            else
            {
                if (EventoSel.direccion != null && EventoSel.fecha != null && EventoSel.tipoEvento != null && ComprobarFecha(EventoSel.fecha))
                {
                    ServicioAPI.PostEvento(this.EventoSel);
                    Terminado = true;
                }
                else
                {
                    ServicioMessageBox.MostrarMessageBox("Tienes que rellenar todos los campos", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
                }
            }
        }

        public bool ComprobarFecha(string fecha)
        {
            string patron = @"^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d$";
            return Regex.IsMatch(fecha, patron);
        }
    }
}
