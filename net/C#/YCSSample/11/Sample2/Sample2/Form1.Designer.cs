namespace Sample2
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
            this.tlp = new System.Windows.Forms.TableLayoutPanel();
            this.tb = new System.Windows.Forms.TextBox();
            this.lb0 = new System.Windows.Forms.Label();
            this.lb1 = new System.Windows.Forms.Label();
            this.lb2 = new System.Windows.Forms.Label();
            this.lb3 = new System.Windows.Forms.Label();
            this.lb4 = new System.Windows.Forms.Label();
            this.bt = new System.Windows.Forms.Button();
            this.tlp.SuspendLayout();
            this.SuspendLayout();
            // 
            // tlp
            // 
            this.tlp.ColumnCount = 2;
            this.tlp.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 49.64789F));
            this.tlp.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50.35211F));
            this.tlp.Controls.Add(this.tb, 1, 0);
            this.tlp.Controls.Add(this.lb0, 0, 0);
            this.tlp.Controls.Add(this.lb1, 0, 1);
            this.tlp.Controls.Add(this.lb2, 1, 1);
            this.tlp.Controls.Add(this.lb3, 0, 2);
            this.tlp.Controls.Add(this.lb4, 1, 2);
            this.tlp.Dock = System.Windows.Forms.DockStyle.Top;
            this.tlp.Location = new System.Drawing.Point(0, 0);
            this.tlp.Name = "tlp";
            this.tlp.RowCount = 3;
            this.tlp.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50.89286F));
            this.tlp.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 49.10714F));
            this.tlp.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 45F));
            this.tlp.Size = new System.Drawing.Size(284, 132);
            this.tlp.TabIndex = 0;
            // 
            // tb
            // 
            this.tb.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tb.Location = new System.Drawing.Point(144, 3);
            this.tb.Name = "tb";
            this.tb.Size = new System.Drawing.Size(137, 23);
            this.tb.TabIndex = 0;
            // 
            // lb0
            // 
            this.lb0.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lb0.AutoSize = true;
            this.lb0.Location = new System.Drawing.Point(25, 14);
            this.lb0.Name = "lb0";
            this.lb0.Size = new System.Drawing.Size(90, 15);
            this.lb0.TabIndex = 1;
            this.lb0.Text = "入力してください。";
            this.lb0.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // lb1
            // 
            this.lb1.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lb1.AutoSize = true;
            this.lb1.Location = new System.Drawing.Point(41, 57);
            this.lb1.Name = "lb1";
            this.lb1.Size = new System.Drawing.Size(58, 15);
            this.lb1.TabIndex = 2;
            this.lb1.Text = "ホスト名：";
            this.lb1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // lb2
            // 
            this.lb2.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lb2.AutoSize = true;
            this.lb2.Location = new System.Drawing.Point(193, 57);
            this.lb2.Name = "lb2";
            this.lb2.Size = new System.Drawing.Size(38, 15);
            this.lb2.TabIndex = 3;
            this.lb2.Text = "label2";
            this.lb2.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // lb3
            // 
            this.lb3.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lb3.AutoSize = true;
            this.lb3.Location = new System.Drawing.Point(38, 101);
            this.lb3.Name = "lb3";
            this.lb3.Size = new System.Drawing.Size(64, 15);
            this.lb3.TabIndex = 4;
            this.lb3.Text = "IPアドレス：";
            // 
            // lb4
            // 
            this.lb4.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.lb4.AutoSize = true;
            this.lb4.Location = new System.Drawing.Point(193, 101);
            this.lb4.Name = "lb4";
            this.lb4.Size = new System.Drawing.Size(38, 15);
            this.lb4.TabIndex = 5;
            this.lb4.Text = "label4";
            // 
            // bt
            // 
            this.bt.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bt.Location = new System.Drawing.Point(0, 138);
            this.bt.Name = "bt";
            this.bt.Size = new System.Drawing.Size(284, 23);
            this.bt.TabIndex = 1;
            this.bt.Text = "検索";
            this.bt.UseVisualStyleBackColor = true;
            this.bt.Click += new System.EventHandler(this.bt_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 161);
            this.Controls.Add(this.bt);
            this.Controls.Add(this.tlp);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.tlp.ResumeLayout(false);
            this.tlp.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private TableLayoutPanel tlp;
        private Button bt;
        private TextBox tb;
        private Label lb0;
        private Label lb1;
        private Label lb2;
        private Label lb3;
        private Label lb4;
    }
}