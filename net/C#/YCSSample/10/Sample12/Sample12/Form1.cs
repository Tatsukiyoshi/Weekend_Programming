using System.Diagnostics;

namespace Sample12
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            string dir = "C:\\";

            string[] name = Directory.GetFiles(dir);

            for(int i = 0; i< name.Length; i++)
            {
                lbx.Items.Add(name[i]);
            }

        }

        private void bt_Click(object sender, EventArgs e)
        {
            string? name = lbx.SelectedItem.ToString();

            if(name != null)
            {
                try
                {
                    Process.Start(@name);
                }
                catch(Exception ex)
                {
                    System.Console.WriteLine(ex.Message);
                }
            }
        }
    }
}
