using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Vistas;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Servicios
{
    public class ServicioNavegacion
    {
        protected ServicioNavegacion() { }

        internal static bool? AbrirDialogoNuevoCliente() => new NuevoCliente().ShowDialog();
        internal static bool? AbrirDialogoEditCliente(Cliente cliente) => new NuevoCliente(cliente).ShowDialog();

        internal static bool? AbrirDialogoNuevoEspectaculo() => new NuevoEspectaculo().ShowDialog();
        internal static bool? AbrirDialogoEditEspectaculo(Espectaculo espectaculo) => new NuevoEspectaculo(espectaculo).ShowDialog();

        internal static bool? AbrirDialogoNuevoEvento() => new NuevoEvento().ShowDialog();

        internal static bool? AbrirDialogoEditEvento(Evento evento) => new NuevoEvento(evento).ShowDialog();

        internal static bool? AbrirDialogoVerCliente(Cliente cliente) => new VerCliente(cliente).ShowDialog();

        internal static bool? AbrirDialogoVerEspectaculo(Espectaculo espectaculo) => new VerEspectaculo(espectaculo).ShowDialog();

    }
}
