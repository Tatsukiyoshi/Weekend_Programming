namespace Sample1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(300, 200);
            this.Text = "サンプル";

            for(int i = 0; i < lb.Length; i++)
            {
                lb[i] = new Label();
                lb[i].Top = i * lb[0].Height;
                lb[i].Width = 300;
            }

            bt = new Button();
            bt.Text = "表示";
            bt.Dock = DockStyle.Bottom;
            bt.Parent = this;

            for(int i = 0; i < lb.Length; i++)
            {
                lb[i].Parent = this;
            }

            bt.Click += new EventHandler(bt_Click);
        }

        private void bt_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                FileInfo fi = new FileInfo(ofd.FileName);
                lb[0].Text = "ファイル名は" + ofd.FileName + "です。";
                lb[1].Text = "絶対パスは" + Path.GetFullPath(ofd.FileName) + "です。";
                lb[2].Text = "サイズは" + Convert.ToString(fi.Length) + "です。";
            }
        }

        #endregion
    }
}