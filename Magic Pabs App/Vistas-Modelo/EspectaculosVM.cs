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
    public class EspectaculosVM : ObservableObject
    {
        private ObservableCollection<Espectaculo> espectaculos;

        public ObservableCollection<Espectaculo> Espectaculos
        {
            get { return espectaculos; }
            set { SetProperty(ref espectaculos, value); }
        }

        private Espectaculo espectaculoSeleccionado;

        public Espectaculo EspectaculoSeleccionado
        {
            get { return espectaculoSeleccionado; }
            set { SetProperty(ref espectaculoSeleccionado, value); }
        }

        public RelayCommand NuevoEspectaculoCommand { get; set; }

        public RelayCommand EditEspectaculoCommand { get; set; }


        public EspectaculosVM()
        {
            this.Espectaculos = ServicioAPI.GetEspectaculos();
            this.EspectaculoSeleccionado = null;
            this.NuevoEspectaculoCommand = new RelayCommand(NuevoEspectaculo);
            this.EditEspectaculoCommand = new RelayCommand(EditEspectaculo);
        }

        //Metodos

        public static void NuevoEspectaculo()
        {
            ServicioNavegacion.AbrirDialogoNuevoEspectaculo();
        }

        public void EditEspectaculo()
        {
            if(EspectaculoSeleccionado != null)
            {
                ServicioNavegacion.AbrirDialogoEditEspectaculo(this.EspectaculoSeleccionado);
            }
            else
            {
                ServicioMessageBox.MostrarMessageBox("No has seleccionado ningun cliente", "Error", System.Windows.MessageBoxButton.OK, System.Windows.MessageBoxImage.Warning);
            }
            
        }

    }
}
