﻿using Magic_Pabs_App.Vistas_Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Magic_Pabs_App.Vistas
{
    /// <summary>
    /// Lógica de interacción para Espectaculos.xaml
    /// </summary>
    public partial class Espectaculos : UserControl
    {
        EspectaculosVM vm = new EspectaculosVM();
        public Espectaculos()
        {
            InitializeComponent();
            DataContext = vm;
        }
    }
}
