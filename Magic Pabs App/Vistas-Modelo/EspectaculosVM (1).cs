using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Servicios;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class EspectaculosVM:ObservableObject
    {
        private ObservableCollection<Espectaculo> espectaculos;

        public ObservableCollection<Espectaculo> Espectaculos
        {
            get { return espectaculos; }
            set { SetProperty(ref espectaculos, value); }
        }

        public EspectaculosVM()
        {
            this.Espectaculos = ServicioAPI.GetEspectaculos();
        }

    }
}
