   M S B A M L   `   `   `  ????I  EMagic Pabs App, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:Magic_Pabs_App.VistasMagic_Pabs_App.Vistas  5      #    Magic_Pabs_App.Vistas.Eventos   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      m iSyncfusion.SfNavigationDrawer.WPF, Version=20.1460.0.48, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89a ]Syncfusion.Shared.Wpf, Version=20.1460.0.52, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89l hSyncfusion.SfTextInputLayout.WPF, Version=20.1460.0.52, Culture=neutral, PublicKeyToken=3d67ed1f87d44c89a ]Syncfusion.SfGrid.WPF, Version=20.1460.0.51, Culture=neutral, PublicKeyToken=3d67ed1f87d44c898
syncfusion!http://schemas.syncfusion.com/wpf     5      5local#clr-namespace:Magic_Pabs_App.Vistas     5      .??5
      ]? .+?5   
   ?? $	??Top=?6   $??35(?5      	EVENTOS6+   ]? 5   
   $??Bottom=?6   ??.  .+?5      ?? $
??50px??6   $
??Left=?5      
?????? 
?????? ??5      ??   ?? Path$  NuevoEventoCommand?.??5      ?? $??/img/plus.png??6   61   5      ?? 5      $
??50px??6   $
??Left=?5      
?????? 
?????? ??5      ?? $  EditEventoCommand?.??5      ?? $??/img/edit.png??6   61   5      ?? 5      $??Right=?6   $	??5pxq?5      ??5      ?? $  VerClienteCommand?.??6@   Ver Cliente6M   ?? 5       $??Right=?6   $	??5pxq?5!      ??5"      ?? $  VerEspectaculoCommand?.??6D   Ver Espectaculo6U   5#      (  "Syncfusion.UI.Xaml.Grid.SfDataGrid  5$   
   -   5          Name$ dataGrid??5%       $
??Left=?5$       $??10q?5&          ColumnSizer$
 Star=?5)          AllowFiltering .    ItemsSource 5'       ?? $  Eventos?(  "Syncfusion.UI.Xaml.Grid.SfGridBase   SelectedItem 5(       ?? $  	EventoSel?5*       5+      5,      