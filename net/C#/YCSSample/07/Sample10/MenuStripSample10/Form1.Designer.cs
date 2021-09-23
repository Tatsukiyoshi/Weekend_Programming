namespace MenuStripSample10
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
            this.ms = new System.Windows.Forms.MenuStrip();
            this.mi0 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi1 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi4 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi5 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi2 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.mi3 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi6 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi7 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi8 = new System.Windows.Forms.ToolStripMenuItem();
            this.mi9 = new System.Windows.Forms.ToolStripMenuItem();
            this.lb = new System.Windows.Forms.Label();
            this.ms.SuspendLayout();
            this.SuspendLayout();
            // 
            // ms
            // 
            this.ms.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mi0,
            this.mi1});
            this.ms.Location = new System.Drawing.Point(0, 0);
            this.ms.Name = "ms";
            this.ms.Size = new System.Drawing.Size(234, 24);
            this.ms.TabIndex = 0;
            this.ms.Text = "menuStrip1";
            // 
            // mi0
            // 
            this.mi0.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mi4,
            this.mi5});
            this.mi0.Name = "mi0";
            this.mi0.Size = new System.Drawing.Size(57, 20);
            this.mi0.Text = "メイン１";
            // 
            // mi1
            // 
            this.mi1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mi2,
            this.toolStripSeparator1,
            this.mi3});
            this.mi1.Name = "mi1";
            this.mi1.Size = new System.Drawing.Size(57, 20);
            this.mi1.Text = "メイン２";
            // 
            // mi4
            // 
            this.mi4.Name = "mi4";
            this.mi4.Size = new System.Drawing.Size(180, 22);
            this.mi4.Text = "乗用車";
            this.mi4.Click += new System.EventHandler(this.mi_Click);
            // 
            // mi5
            // 
            this.mi5.Name = "mi5";
            this.mi5.Size = new System.Drawing.Size(180, 22);
            this.mi5.Text = "トラック";
            this.mi5.Click += new System.EventHandler(this.mi_Click);
            // 
            // mi2
            // 
            this.mi2.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mi6,
            this.mi7});
            this.mi2.Name = "mi2";
            this.mi2.Size = new System.Drawing.Size(180, 22);
            this.mi2.Text = "サブ１";
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(102, 6);
            // 
            // mi3
            // 
            this.mi3.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mi8,
            this.mi9});
            this.mi3.Name = "mi3";
            this.mi3.Size = new System.Drawing.Size(180, 22);
            this.mi3.Text = "サブ２";
            // 
            // mi6
            // 
            this.mi6.Name = "mi6";
            this.mi6.Size = new System.Drawing.Size(180, 22);
            this.mi6.Text = "オープンカー";
            this.mi6.Click += new System.EventHandler(this.mi_Click);
            // 
            // mi7
            // 
            this.mi7.Name = "mi7";
            this.mi7.Size = new System.Drawing.Size(180, 22);
            this.mi7.Text = "タクシー";
            this.mi7.Click += new System.EventHandler(this.mi_Click);
            // 
            // mi8
            // 
            this.mi8.Name = "mi8";
            this.mi8.Size = new System.Drawing.Size(180, 22);
            this.mi8.Text = "スポーツカー";
            this.mi8.Click += new System.EventHandler(this.mi_Click);
            // 
            // mi9
            // 
            this.mi9.Name = "mi9";
            this.mi9.Size = new System.Drawing.Size(180, 22);
            this.mi9.Text = "ミニカー";
            this.mi9.Click += new System.EventHandler(this.mi_Click);
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.lb.Location = new System.Drawing.Point(0, 146);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(87, 15);
            this.lb.TabIndex = 1;
            this.lb.Text = "いらっしゃいませ。";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(234, 161);
            this.Controls.Add(this.lb);
            this.Controls.Add(this.ms);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.ms.ResumeLayout(false);
            this.ms.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip ms;
        private System.Windows.Forms.ToolStripMenuItem mi0;
        private System.Windows.Forms.ToolStripMenuItem mi4;
        private System.Windows.Forms.ToolStripMenuItem mi5;
        private System.Windows.Forms.ToolStripMenuItem mi1;
        private System.Windows.Forms.ToolStripMenuItem mi2;
        private System.Windows.Forms.ToolStripMenuItem mi6;
        private System.Windows.Forms.ToolStripMenuItem mi7;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem mi3;
        private System.Windows.Forms.ToolStripMenuItem mi8;
        private System.Windows.Forms.ToolStripMenuItem mi9;
        private System.Windows.Forms.Label lb;
    }
}

