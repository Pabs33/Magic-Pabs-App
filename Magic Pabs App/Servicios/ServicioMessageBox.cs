using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Magic_Pabs_App.Servicios
{
    static class ServicioMessageBox
    {
        public static void MostrarMessageBox(string mensaje, string titulo, MessageBoxButton boxButton, MessageBoxImage messageBoxImage)
        {
            MessageBox.Show(mensaje, titulo, boxButton, messageBoxImage);
        }
    }
}
