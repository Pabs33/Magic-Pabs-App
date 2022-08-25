using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Clases
{
    public class Espectaculo
    {
        public int idEspectaculo { get; set; }
        public string titulo { get; set; }
        public string descripcion { get; set; }
        public int duracion { get; set; }

        public Espectaculo() { }

        public Espectaculo(int id, int duracion, string descripcion, string titulo)
        {
            this.idEspectaculo = id;
            this.duracion = duracion;
            this.descripcion = descripcion;
            this.titulo = titulo;
        }

        public override string ToString()
        {
            return titulo;
        }
    }
}
