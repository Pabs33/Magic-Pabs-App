using Magic_Pabs_App.Vistas;
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

namespace Magic_Pabs_App
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.contentControl.Content = new Index();
        }

        private void NavigationDrawer_ItemClicked(object sender, Syncfusion.UI.Xaml.NavigationDrawer.NavigationItemClickedEventArgs e)
        {
            switch (e.Item.Tag)
            {
                case "Index":
                    this.contentControl.Content = new Index();
                    break;
                case "Clientes":
                    this.contentControl.Content = new Clientes();
                    break;
                case "Eventos":
                    this.contentControl.Content = new Eventos();
                    break;
                case "Espectaculos":
                    this.contentControl.Content = new Espectaculos();
                    break;
                default:
                    break;
            }
        }
    }
}
