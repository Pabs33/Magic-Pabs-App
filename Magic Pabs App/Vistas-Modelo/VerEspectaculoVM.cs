using Magic_Pabs_App.Clases;
using Microsoft.Toolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Vistas_Modelo
{
    class VerEspectaculoVM:ObservableObject
    {
        private Espectaculo espectaculo;

        public Espectaculo Espectaculo
        {
            get { return espectaculo; }
            set { SetProperty(ref espectaculo, value); }
        }

        public VerEspectaculoVM(Espectaculo espectaculo)
        {
            this.Espectaculo = espectaculo;
        }
    }
}
