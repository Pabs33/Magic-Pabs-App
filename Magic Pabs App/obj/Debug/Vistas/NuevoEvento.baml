   M S B A M L   `   `   `  ????I  EMagic Pabs App, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:Magic_Pabs_App.VistasMagic_Pabs_App.Vistas  5   	   '    !Magic_Pabs_App.Vistas.NuevoEvento   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   m iSyncfusion.SfNavigationDrawer.WPF, Version=20.1460.0.48, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89a ]Syncfusion.Shared.Wpf, Version=20.1460.0.52, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89l hSyncfusion.SfTextInputLayout.WPF, Version=20.1460.0.52, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89a ]Syncfusion.SfGrid.WPF, Version=20.1460.0.51, Culture=neutral, PublicKeyToken=3d67ed1f87d44c898
syncfusion!http://schemas.syncfusion.com/wpf     5   	   5local#clr-namespace:Magic_Pabs_App.Vistas     5   	     ? Title$  NuevoEvento??5	   	   $	??350??6   $	??400??6*    ? ShowInTaskbar .   ? 
ResizeMode$ NoResize=?5   	   ???#6BD7ED ? Icon$ /img/negre.ico??5   	   .??5      ?? $	??5pxq?6   .+?5   
   :  4Syncfusion.UI.Xaml.TextInputLayout.SfTextInputLayout     Hint$ 	Direccion??6'      HintFloatMode$ Float=?5   '      
HelperText$' !Introduce la direccion del evento??5   '      LeadingView 5      ?? 5      $??/img/hogar.png??6      	InputView. 5      ?? ??6   ?? 	 ?? Path$	 EventoSel.direccion?5        5   
   $ Fecha??6'   $ Float=?5   '   $0 *Introduce la fecha del evento (dd/mm/yyyy)??5   '    5      ?? 5      $??/img/calendar.png??6   . 5      ?? ??6   ?? $	 EventoSel.fecha?5        5   
   $ Tipo de evento??6'   $ Float=?5    '   $R LIntroduce el tipo de evento(bodas, bautizos, comuniones e incluso funerales)??5!   '    5"      ?? 5#      $??/img/confetti.png??6   . 5%      ?? ??6   ?? $	 EventoSel.tipoEvento?5&      ?? 5(   
   
Cliente:6   ?? 5)   
   ??6   ?? $	 ListaClientes?
 ?? SelectedItem
 5*      ?? $ 	 EventoSel.idClienteEventos?6N   ?? 5,   
   Espectaculo:6"   ?? 5-   
   ??6   ?? $	 ListaEspectaculos?
 5.      ?? $$	 EventoSel.idEspectaculoEventos?6R   ?? 5/   
   -   5        ???#4994A3$??100px??51      .??6   Guardar Evento6/   53      54      