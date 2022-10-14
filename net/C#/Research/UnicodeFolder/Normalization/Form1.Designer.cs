namespace Normalization
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
            this.InputTextBox = new System.Windows.Forms.TextBox();
            this.UnicodeGroupBox = new System.Windows.Forms.GroupBox();
            this.UnicodeFormD = new System.Windows.Forms.RadioButton();
            this.UnicodeFormC = new System.Windows.Forms.RadioButton();
            this.OutputLabel = new System.Windows.Forms.Label();
            this.MethodGroupBox = new System.Windows.Forms.GroupBox();
            this.InstanceMethod = new System.Windows.Forms.RadioButton();
            this.StaticMethod = new System.Windows.Forms.RadioButton();
            this.UnicodeGroupBox.SuspendLayout();
            this.MethodGroupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // InputTextBox
            // 
            this.InputTextBox.Location = new System.Drawing.Point(26, 79);
            this.InputTextBox.Name = "InputTextBox";
            this.InputTextBox.Size = new System.Drawing.Size(150, 31);
            this.InputTextBox.TabIndex = 0;
            this.InputTextBox.TextChanged += new System.EventHandler(this.InputTextBox_TextChanged);
            // 
            // UnicodeGroupBox
            // 
            this.UnicodeGroupBox.Controls.Add(this.UnicodeFormD);
            this.UnicodeGroupBox.Controls.Add(this.UnicodeFormC);
            this.UnicodeGroupBox.Enabled = false;
            this.UnicodeGroupBox.Location = new System.Drawing.Point(235, 41);
            this.UnicodeGroupBox.Name = "UnicodeGroupBox";
            this.UnicodeGroupBox.Size = new System.Drawing.Size(300, 150);
            this.UnicodeGroupBox.TabIndex = 1;
            this.UnicodeGroupBox.TabStop = false;
            this.UnicodeGroupBox.Text = "正規形";
            // 
            // UnicodeFormD
            // 
            this.UnicodeFormD.AutoSize = true;
            this.UnicodeFormD.Location = new System.Drawing.Point(36, 94);
            this.UnicodeFormD.Name = "UnicodeFormD";
            this.UnicodeFormD.Size = new System.Drawing.Size(104, 29);
            this.UnicodeFormD.TabIndex = 1;
            this.UnicodeFormD.TabStop = true;
            this.UnicodeFormD.Text = "正規形D";
            this.UnicodeFormD.UseVisualStyleBackColor = true;
            this.UnicodeFormD.CheckedChanged += new System.EventHandler(this.Form_CheckedChanged);
            // 
            // UnicodeFormC
            // 
            this.UnicodeFormC.AutoSize = true;
            this.UnicodeFormC.Location = new System.Drawing.Point(36, 40);
            this.UnicodeFormC.Name = "UnicodeFormC";
            this.UnicodeFormC.Size = new System.Drawing.Size(102, 29);
            this.UnicodeFormC.TabIndex = 0;
            this.UnicodeFormC.TabStop = true;
            this.UnicodeFormC.Text = "正規形C";
            this.UnicodeFormC.UseVisualStyleBackColor = true;
            this.UnicodeFormC.CheckedChanged += new System.EventHandler(this.Form_CheckedChanged);
            // 
            // OutputLabel
            // 
            this.OutputLabel.AutoSize = true;
            this.OutputLabel.Enabled = false;
            this.OutputLabel.Font = new System.Drawing.Font("Meiryo UI", 9F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point);
            this.OutputLabel.ForeColor = System.Drawing.Color.Red;
            this.OutputLabel.Location = new System.Drawing.Point(564, 81);
            this.OutputLabel.Name = "OutputLabel";
            this.OutputLabel.Size = new System.Drawing.Size(0, 23);
            this.OutputLabel.TabIndex = 2;
            // 
            // MethodGroupBox
            // 
            this.MethodGroupBox.Controls.Add(this.InstanceMethod);
            this.MethodGroupBox.Controls.Add(this.StaticMethod);
            this.MethodGroupBox.Enabled = false;
            this.MethodGroupBox.Location = new System.Drawing.Point(239, 222);
            this.MethodGroupBox.Name = "MethodGroupBox";
            this.MethodGroupBox.Size = new System.Drawing.Size(300, 150);
            this.MethodGroupBox.TabIndex = 3;
            this.MethodGroupBox.TabStop = false;
            this.MethodGroupBox.Text = "メソッド";
            // 
            // InstanceMethod
            // 
            this.InstanceMethod.AutoSize = true;
            this.InstanceMethod.Location = new System.Drawing.Point(37, 94);
            this.InstanceMethod.Name = "InstanceMethod";
            this.InstanceMethod.Size = new System.Drawing.Size(102, 29);
            this.InstanceMethod.TabIndex = 1;
            this.InstanceMethod.TabStop = true;
            this.InstanceMethod.Text = "Instance";
            this.InstanceMethod.UseVisualStyleBackColor = true;
            this.InstanceMethod.CheckedChanged += new System.EventHandler(this.Method_CheckedChanged);
            // 
            // StaticMethod
            // 
            this.StaticMethod.AutoSize = true;
            this.StaticMethod.Location = new System.Drawing.Point(37, 40);
            this.StaticMethod.Name = "StaticMethod";
            this.StaticMethod.Size = new System.Drawing.Size(80, 29);
            this.StaticMethod.TabIndex = 0;
            this.StaticMethod.TabStop = true;
            this.StaticMethod.Text = "Static";
            this.StaticMethod.UseVisualStyleBackColor = true;
            this.StaticMethod.CheckedChanged += new System.EventHandler(this.Method_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.MethodGroupBox);
            this.Controls.Add(this.OutputLabel);
            this.Controls.Add(this.UnicodeGroupBox);
            this.Controls.Add(this.InputTextBox);
            this.Name = "Form1";
            this.Text = "Normalization";
            this.UnicodeGroupBox.ResumeLayout(false);
            this.UnicodeGroupBox.PerformLayout();
            this.MethodGroupBox.ResumeLayout(false);
            this.MethodGroupBox.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox InputTextBox;
        private GroupBox UnicodeGroupBox;
        private RadioButton UnicodeFormD;
        private RadioButton UnicodeFormC;
        private Label OutputLabel;
        private GroupBox MethodGroupBox;
        private RadioButton InstanceMethod;
        private RadioButton StaticMethod;
    }
}