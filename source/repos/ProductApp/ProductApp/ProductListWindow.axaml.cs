using Avalonia;
using Avalonia.Controls;
using Avalonia.Markup.Xaml;
using ProductApp.Models;
using System.Collections.Generic;

namespace ProductApp;

public partial class ProductListWindow : Window
{
    public ProductListWindow(List<Product> products)
    {
        InitializeComponent();
        ProductListBox.ItemsSource = products;
    }

    private void Close_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
    {
        Close();
    }
}