using Avalonia;
using Avalonia.Controls;
using ProductApp.Models;
using System.Collections.Generic;
using System;

namespace ProductApp
{
    public partial class MainWindow : Window
    {
        private List<Product> products = new List<Product>();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void AddProduct_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            string name = ProductNameInput.Text;
            if (decimal.TryParse(ProductPriceInput.Text, out decimal price))
            {
                products.Add(new Product { Name = name, Price = price });
                ProductNameInput.Clear();
                ProductPriceInput.Clear();
            }
            else
            {
                var errorBox = new Window
                {
                    Content = new TextBlock { Text = "Цена должна быть числом!", Margin = new Thickness(20) },
                    Width = 300,
                    Height = 100
                };
                errorBox.ShowDialog(this);
            }
        }

        private void ShowProductList_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
        {
            var productListWindow = new ProductListWindow(products);
            productListWindow.ShowDialog(this);
        }

    }
}

