using Microsoft.Toolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Clases
{
    public class Evento
    {
        public int idEvento { get; set; }
        public Cliente idClienteEventos { get; set; }
        public string tipoEvento { get; set; }
        public string direccion { get; set; }
        public string fecha { get; set; }
        public Espectaculo idEspectaculoEventos { get; set; }
        


        public Evento() { }

        public Evento(int id, Cliente cliente, string tipoEvento, string direccion, string fecha, Espectaculo espectaculo)
        {
            this.idEvento= id;
            this.idClienteEventos = cliente;
            this.tipoEvento = tipoEvento;
            this.direccion = direccion;
            this.fecha = fecha;
            this.idEspectaculoEventos = espectaculo;
        }
    }
}
