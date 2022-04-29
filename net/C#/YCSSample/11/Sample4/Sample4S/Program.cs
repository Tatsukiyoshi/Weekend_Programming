// See https://aka.ms/new-console-template for more information
using System.Net;
using System.Net.Sockets;

class Sample4S
{
    public static string HOST = "localhost";
    public static int PORT = 10000;

    public static void Main()
    {
        IPHostEntry ih = Dns.GetHostEntry(HOST);

        TcpListener tl = new TcpListener(ih.AddressList[0], PORT);
        tl.Start();

        Console.WriteLine("待機します");

        while (true)
        {
            TcpClient tcpClient = tl.AcceptTcpClient();
            StreamWriter sw = new StreamWriter(tcpClient.GetStream());
            sw.WriteLine("こちらはサーバです。");

            sw.Flush();
            sw.Close();
            tcpClient.Close();
            break;
        }
    }
}
