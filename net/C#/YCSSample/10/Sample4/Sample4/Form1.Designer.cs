using System.Drawing.Imaging;

namespace Sample4
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private Button bt1, bt2;
        private FlowLayoutPanel flp;
        private Bitmap bmp;

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
            this.ClientSize = new System.Drawing.Size(400, 300);
            this.Text = "サンプル";

            bmp = new Bitmap(400, 300);

            bt1 = new Button();
            bt2 = new Button();
            bt1.Text = "読込";
            bt2.Text = "保存";

            flp = new FlowLayoutPanel();
            flp.Dock = DockStyle.Bottom;

            bt1.Parent = flp;
            bt2.Parent = flp;
            flp.Parent = this;

            bt1.Click += new EventHandler(bt1_Click);
            bt2.Click += new EventHandler(bt2_Click);
            this.Paint += new PaintEventHandler(fm_Paint);

        }

        private void bt1_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "ビットマップファイル|*.bmp|JPEGファイル|*.jpg";

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                Image tmp = (Bitmap)Image.FromFile(ofd.FileName);
                bmp = new Bitmap(tmp);
            }
            this.Invalidate();
        }

        private void bt2_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "ビットマップファイル|*.bmp|JPEGファイル|*.jpg";

            if(sfd.ShowDialog() == DialogResult.OK)
            {
                switch (sfd.FilterIndex)
                {
                    case 1: // Bitmap
                        bmp.Save(sfd.FileName, ImageFormat.Bmp);
                        break;
                    case 2: // JPEG
                        bmp.Save(sfd.FileName, ImageFormat.Jpeg);
                        break;
                    default:
                        break;
                }
            }
            this.Invalidate();
        }

        private void fm_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawImage(bmp, 0, 0);
        }

        #endregion
    }
}