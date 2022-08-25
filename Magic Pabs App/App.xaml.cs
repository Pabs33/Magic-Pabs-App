using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace Magic_Pabs_App
{
    /// <summary>
    /// Lógica de interacción para App.xaml
    /// </summary>
    public partial class App : Application
    {
        public App()
        {
            //Registro de las claves de Syncfusion
            Syncfusion.Licensing.SyncfusionLicenseProvider.RegisterLicense("");
        }
    }
}
