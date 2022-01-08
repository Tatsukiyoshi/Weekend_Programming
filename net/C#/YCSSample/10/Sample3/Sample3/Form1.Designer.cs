namespace Sample3
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

        private TextBox[] tb = new TextBox[5];
        private Button bt1, bt2;
        private FlowLayoutPanel flp;

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(250, 200);
            this.Text = "サンプル";

            for(int i = 0; i < tb.Length; i++)
            {
                tb[i] = new TextBox();
                tb[i].Width = 30;
                tb[i].Height = 30;
                tb[i].Top = 0;
                tb[i].Left = i * tb[i].Width;
                tb[i].Text = Convert.ToString(i);
            }

            // ボタン
            bt1 = new Button();
            bt2 = new Button();
            bt1.Text = "読込";
            bt2.Text = "保存";

            // 
            flp = new FlowLayoutPanel();
            flp.Dock = DockStyle.Bottom;

            bt1.Parent = flp;
            bt2.Parent = flp;
            flp.Parent = this;
            for(int i = 0; i < tb.Length; i++)
            {
                tb[i].Parent = this;
            }

            bt1.Click += new EventHandler(bt1_Click);
            bt2.Click += new EventHandler(bt2_Click);
        }

        private void bt1_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Filter = "バイナリファイル|*.bin";

            if(ofd.ShowDialog() == DialogResult.OK)
            {
                BinaryReader br = new BinaryReader(
                    new FileStream(ofd.FileName, FileMode.Open, FileAccess.Read));
                for(int i = 0; i < tb.Length; i++)
                {
                    int num = br.ReadInt32();
                    tb[i].Text = Convert.ToString(num);
                }
                br.Close();
            }
        }

        private void bt2_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "バイナリファイル|*.bin";

            if(sfd.ShowDialog() == DialogResult.OK)
            {
                BinaryWriter bw =
                    new BinaryWriter(
                        new FileStream(sfd.FileName,
                        FileMode.OpenOrCreate,
                        FileAccess.Write));
                for(int i = 0; i < tb.Length; i++)
                {
                    bw.Write(Convert.ToInt32(tb[i].Text));
                }
                bw.Close();
            }
        }

        #endregion
    }
}