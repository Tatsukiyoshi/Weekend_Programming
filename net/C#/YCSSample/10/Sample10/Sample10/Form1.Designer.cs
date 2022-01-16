using System.Text.RegularExpressions;

namespace Sample10
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private Label[] lb = new Label[3];
        private TextBox[] tb = new TextBox[3];
        private Button bt;
        private TableLayoutPanel tlp;

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
            this.ClientSize = new System.Drawing.Size(300, 300);
            this.Text = "サンプル";

            // ラベル配置
            for(int i = 0; i < lb.Length; i++)
            {
                lb[i] = new Label();
                lb[i].Dock = DockStyle.Fill;
            }

            // テキストボックス配置
            for(int i = 0; i < tb.Length; i++)
            {
                tb[i] = new TextBox();
                tb[i].Dock = DockStyle.Fill;
            }

            bt = new Button();

            tlp = new TableLayoutPanel();
            tlp.ColumnCount = 2;
            tlp.RowCount = 5;
            tlp.Dock = DockStyle.Fill;

            lb[0].Text = "入力してください。";
            tlp.SetColumnSpan(lb[0], 2);

            tb[0].Multiline = true;
            tb[0].Height = 100;
            tlp.SetColumnSpan(tb[0], 2);

            lb[1].Text = "置換前";
            lb[2].Text = "置換後";
            bt.Text = "置換";
            tlp.SetColumnSpan(bt, 2);

            lb[0].Parent = tlp;
            tb[0].Parent = tlp;
            lb[1].Parent = tlp;
            tb[1].Parent = tlp;
            lb[2].Parent = tlp;
            tb[2].Parent = tlp;
            bt.Parent = tlp;

            tlp.Parent = this;

            bt.Click += new EventHandler(bt_Click);
        }

        private void bt_Click(object sender, EventArgs e)
        {
            Regex rx = new Regex(tb[1].Text);
            tb[0].Text = rx.Replace(tb[0].Text, tb[2].Text);
        }

        #endregion
    }
}