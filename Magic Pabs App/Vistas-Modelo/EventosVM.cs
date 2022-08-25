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
    class EventosVM:ObservableObject
    {
        private ObservableCollection<Evento> eventos;

        public ObservableCollection<Evento> Eventos
        {
            get { return eventos; }
            set { SetProperty(ref eventos, value); }
        }

        private Evento eventoSel;

        public Evento EventoSel
        {
            get { return eventoSel; }
            set { SetProperty(ref eventoSel, value); }
        }


        public RelayCommand NuevoEventoCommand{ get; set; }

        public RelayCommand EditEventoCommand { get; set; }

        public RelayCommand VerClienteCommand { get; set; }

        public RelayCommand VerEspectaculoCommand { get; set; }


        public EventosVM()
        {
            this.Eventos = ServicioAPI.GetEventos();
            this.NuevoEventoCommand = new RelayCommand(NuevoEvento);
            this.EditEventoCommand = new RelayCommand(EditEvento);
            this.VerClienteCommand = new RelayCommand(VerCliente);
            this.VerEspectaculoCommand = new RelayCommand(VerEspectaculo);
            this.EventoSel = null;
        }

        //metodos
        public void NuevoEvento()
        {
            ServicioNavegacion.AbrirDialogoNuevoEvento();
        }

        public void EditEvento()
        {
            if(EventoSel != null)
            {
                ServicioNavegacion.AbrirDialogoEditEvento(EventoSel);
            }
            else
            {
                ServicioMessageBox.MostrarMessageBox("No has seleccionado ningun evento", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
            }
            
        }

        public void VerEspectaculo()
        {
            if (EventoSel != null)
            {
                ServicioNavegacion.AbrirDialogoVerEspectaculo(EventoSel.idEspectaculoEventos);
            }
            else
            {
                ServicioMessageBox.MostrarMessageBox("No has seleccionado ningun evento", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
            }
        }

        public void VerCliente()
        {
            if (EventoSel != null)
            {
                ServicioNavegacion.AbrirDialogoVerCliente(EventoSel.idClienteEventos);
            }
            else
            {
                ServicioMessageBox.MostrarMessageBox("No has seleccionado ningun evento", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
            }
        }
    }
}
