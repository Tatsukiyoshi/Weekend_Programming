namespace Sample9
{
    internal class ChildForm : Form
    {
        TextBox tb;

        public ChildForm(string name)
        {
            this.Text = name;

            tb = new TextBox();
            tb.Multiline = true;
            tb.Width = this.Width;
            tb.Height = this.Height;

            StreamReader sr = new StreamReader(name, System.Text.Encoding.Default);

            tb.Text = sr.ReadToEnd();
            sr.Close();

            tb.Parent = this;
        }
    }
}