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
    class NuevoEspectaculoVM: ObservableObject
    {
        private Espectaculo espectaculo;

        public Espectaculo Espectaculo
        {
            get { return espectaculo; }
            set { SetProperty(ref espectaculo, value); }
        }

        public bool Edit { get; set; }

        public bool Terminado { get; set; }

        public NuevoEspectaculoVM()
        {
            this.Espectaculo = new Espectaculo();
            Edit = false;
            Terminado = false;
        }

        public NuevoEspectaculoVM(Espectaculo espectaculo)
        {
            this.Espectaculo = espectaculo;
            Edit = true;
            Terminado = false;
        }


        //metodos
        public void NuevoEspectaculo()
        {
            if (Edit && Espectaculo.titulo != null && Espectaculo.duracion != 0 && Espectaculo.descripcion != null)
            {
                ServicioAPI.PutEspectaculo(Espectaculo);
                Terminado = true;
                
            }
            else
            {
                if (Espectaculo.titulo != null && Espectaculo.duracion != 0 && Espectaculo.descripcion != null)
                {
                    Espectaculo.idEspectaculo = 0;
                    ServicioAPI.PostEspectaculo(Espectaculo);
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
