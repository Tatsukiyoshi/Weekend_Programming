namespace Item2
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
            this.lb = new System.Windows.Forms.Label();
            this.gb = new System.Windows.Forms.GroupBox();
            this.rb3 = new System.Windows.Forms.RadioButton();
            this.rb2 = new System.Windows.Forms.RadioButton();
            this.rb1 = new System.Windows.Forms.RadioButton();
            this.gb.SuspendLayout();
            this.SuspendLayout();
            // 
            // lb
            // 
            this.lb.AutoSize = true;
            this.lb.Dock = System.Windows.Forms.DockStyle.Top;
            this.lb.Location = new System.Drawing.Point(0, 0);
            this.lb.Name = "lb";
            this.lb.Size = new System.Drawing.Size(34, 12);
            this.lb.TabIndex = 0;
            this.lb.Text = "Hello!";
            // 
            // gb
            // 
            this.gb.Controls.Add(this.rb3);
            this.gb.Controls.Add(this.rb2);
            this.gb.Controls.Add(this.rb1);
            this.gb.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.gb.Location = new System.Drawing.Point(0, 49);
            this.gb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.gb.Name = "gb";
            this.gb.Padding = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.gb.Size = new System.Drawing.Size(201, 80);
            this.gb.TabIndex = 1;
            this.gb.TabStop = false;
            this.gb.Text = "種類";
            // 
            // rb3
            // 
            this.rb3.AutoSize = true;
            this.rb3.Font = new System.Drawing.Font("Yu Gothic UI", 9F, System.Drawing.FontStyle.Italic);
            this.rb3.Location = new System.Drawing.Point(5, 55);
            this.rb3.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rb3.Name = "rb3";
            this.rb3.Size = new System.Drawing.Size(68, 19);
            this.rb3.TabIndex = 2;
            this.rb3.TabStop = true;
            this.rb3.Text = "イタリック";
            this.rb3.UseVisualStyleBackColor = true;
            this.rb3.CheckedChanged += new System.EventHandler(this.rb3_CheckedChanged);
            // 
            // rb2
            // 
            this.rb2.AutoSize = true;
            this.rb2.Font = new System.Drawing.Font("Yu Gothic UI", 9F, System.Drawing.FontStyle.Bold);
            this.rb2.Location = new System.Drawing.Point(5, 35);
            this.rb2.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rb2.Name = "rb2";
            this.rb2.Size = new System.Drawing.Size(49, 19);
            this.rb2.TabIndex = 1;
            this.rb2.TabStop = true;
            this.rb2.Text = "太字";
            this.rb2.UseVisualStyleBackColor = true;
            this.rb2.CheckedChanged += new System.EventHandler(this.rb2_CheckedChanged);
            // 
            // rb1
            // 
            this.rb1.AutoSize = true;
            this.rb1.Location = new System.Drawing.Point(5, 15);
            this.rb1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rb1.Name = "rb1";
            this.rb1.Size = new System.Drawing.Size(47, 16);
            this.rb1.TabIndex = 0;
            this.rb1.TabStop = true;
            this.rb1.Text = "普通";
            this.rb1.UseVisualStyleBackColor = true;
            this.rb1.CheckedChanged += new System.EventHandler(this.rb1_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(201, 129);
            this.Controls.Add(this.gb);
            this.Controls.Add(this.lb);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.gb.ResumeLayout(false);
            this.gb.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lb;
        private System.Windows.Forms.GroupBox gb;
        private System.Windows.Forms.RadioButton rb3;
        private System.Windows.Forms.RadioButton rb2;
        private System.Windows.Forms.RadioButton rb1;
    }
}

