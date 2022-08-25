using Magic_Pabs_App.Clases;
using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Magic_Pabs_App.Servicios
{
    static class ServicioAPI
    {

        public readonly static string endpoint = "http://localhost:8081/apirestmagicpabs/api/";

        // Clientes
        public static ObservableCollection<Cliente> GetClientes()
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("clientes", Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Cliente>>(response.Content);
        } 

        public static void PostCliente(Cliente cliente)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("clientes", Method.POST);
            string data = JsonConvert.SerializeObject(cliente);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }

        public static void PutCliente(Cliente cliente)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("clientes", Method.PUT);
            string data = JsonConvert.SerializeObject(cliente);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }

        //Espectaculos
        public static ObservableCollection<Espectaculo>GetEspectaculos()
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("espectaculos", Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Espectaculo>>(response.Content);
        }

        public static void PostEspectaculo(Espectaculo espectaculo)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("espectaculos", Method.POST);
            string data = JsonConvert.SerializeObject(espectaculo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }

        public static void PutEspectaculo(Espectaculo espectaculo)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("espectaculos", Method.PUT);
            string data = JsonConvert.SerializeObject(espectaculo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }

        //Eventos
        public static ObservableCollection<Evento> GetEventos()
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("eventos", Method.GET);
            var response = client.Execute(request);
            return JsonConvert.DeserializeObject<ObservableCollection<Evento>>(response.Content);
        }

        public static void PostEvento(Evento evento)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("eventos", Method.POST);
            string data = JsonConvert.SerializeObject(evento);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }

        public static void PutEvento(Evento evento)
        {
            var client = new RestClient(endpoint);
            var request = new RestRequest("eventos", Method.PUT);
            string data = JsonConvert.SerializeObject(evento);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            client.Execute(request);
        }
    }
}
