using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Clases
{
    public class Cliente
    {
        public int idCliente { get; set; }
        public string email { get; set; }
        public string nombre { get; set; }
        public string telefono { get; set; }

        public Cliente() { }

        public Cliente(int id, string email, string nombre, string telefono)
        {
            this.idCliente = id;
            this.email = email;
            this.nombre = nombre;
            this.telefono = telefono;
        }

        public override string ToString()
        {
            return nombre;
        }
    }
}
