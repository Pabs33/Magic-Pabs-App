﻿using Magic_Pabs_App.Clases;
using Magic_Pabs_App.Vistas_Modelo;
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
using System.Windows.Shapes;

namespace Magic_Pabs_App.Vistas
{
    /// <summary>
    /// Lógica de interacción para VerEspectaculo.xaml
    /// </summary>
    public partial class VerEspectaculo : Window
    {
        public VerEspectaculo()
        {
            InitializeComponent();
        }

        public VerEspectaculo(Espectaculo espectaculo)
        {
            InitializeComponent();
            this.DataContext = new VerEspectaculoVM(espectaculo);
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = true;
        }
    }
}
