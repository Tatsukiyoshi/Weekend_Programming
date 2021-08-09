
namespace WindowsFormsApp2
{
    partial class SettingForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.FullColorOn = new System.Windows.Forms.RadioButton();
            this.ModeSelection = new System.Windows.Forms.GroupBox();
            this.FullColorOff = new System.Windows.Forms.RadioButton();
            this.SampleText = new System.Windows.Forms.Label();
            this.ColorSelectButton = new System.Windows.Forms.Button();
            this.CloseButton = new System.Windows.Forms.Button();
            this.ScopeSelection = new System.Windows.Forms.GroupBox();
            this.SolidOnly = new System.Windows.Forms.RadioButton();
            this.SelectAll = new System.Windows.Forms.RadioButton();
            this.ModeSelection.SuspendLayout();
            this.ScopeSelection.SuspendLayout();
            this.SuspendLayout();
            // 
            // FullColorOn
            // 
            this.FullColorOn.AutoSize = true;
            this.FullColorOn.Location = new System.Drawing.Point(6, 18);
            this.FullColorOn.Name = "FullColorOn";
            this.FullColorOn.Size = new System.Drawing.Size(71, 16);
            this.FullColorOn.TabIndex = 3;
            this.FullColorOn.TabStop = true;
            this.FullColorOn.Text = "作成可能";
            this.FullColorOn.UseVisualStyleBackColor = true;
            // 
            // ModeSelection
            // 
            this.ModeSelection.Controls.Add(this.FullColorOff);
            this.ModeSelection.Controls.Add(this.FullColorOn);
            this.ModeSelection.Location = new System.Drawing.Point(12, 37);
            this.ModeSelection.Name = "ModeSelection";
            this.ModeSelection.Size = new System.Drawing.Size(117, 71);
            this.ModeSelection.TabIndex = 2;
            this.ModeSelection.TabStop = false;
            this.ModeSelection.Text = "選択モード";
            // 
            // FullColorOff
            // 
            this.FullColorOff.AutoSize = true;
            this.FullColorOff.Location = new System.Drawing.Point(7, 41);
            this.FullColorOff.Name = "FullColorOff";
            this.FullColorOff.Size = new System.Drawing.Size(71, 16);
            this.FullColorOff.TabIndex = 4;
            this.FullColorOff.TabStop = true;
            this.FullColorOff.Text = "作成不可";
            this.FullColorOff.UseVisualStyleBackColor = true;
            // 
            // SampleText
            // 
            this.SampleText.AutoSize = true;
            this.SampleText.Location = new System.Drawing.Point(19, 13);
            this.SampleText.Name = "SampleText";
            this.SampleText.Size = new System.Drawing.Size(43, 12);
            this.SampleText.TabIndex = 0;
            this.SampleText.Text = "サンプル";
            // 
            // ColorSelectButton
            // 
            this.ColorSelectButton.Location = new System.Drawing.Point(78, 8);
            this.ColorSelectButton.Name = "ColorSelectButton";
            this.ColorSelectButton.Size = new System.Drawing.Size(75, 23);
            this.ColorSelectButton.TabIndex = 1;
            this.ColorSelectButton.Text = "選択";
            this.ColorSelectButton.UseVisualStyleBackColor = true;
            this.ColorSelectButton.Click += new System.EventHandler(this.ColorSelectButton_Click);
            // 
            // CloseButton
            // 
            this.CloseButton.Location = new System.Drawing.Point(104, 125);
            this.CloseButton.Name = "CloseButton";
            this.CloseButton.Size = new System.Drawing.Size(75, 23);
            this.CloseButton.TabIndex = 8;
            this.CloseButton.Text = "OK";
            this.CloseButton.UseVisualStyleBackColor = true;
            this.CloseButton.Click += new System.EventHandler(this.CloseButton_Click);
            // 
            // ScopeSelection
            // 
            this.ScopeSelection.Controls.Add(this.SolidOnly);
            this.ScopeSelection.Controls.Add(this.SelectAll);
            this.ScopeSelection.Location = new System.Drawing.Point(150, 37);
            this.ScopeSelection.Name = "ScopeSelection";
            this.ScopeSelection.Size = new System.Drawing.Size(117, 71);
            this.ScopeSelection.TabIndex = 5;
            this.ScopeSelection.TabStop = false;
            this.ScopeSelection.Text = "選択範囲";
            // 
            // SolidOnly
            // 
            this.SolidOnly.AutoSize = true;
            this.SolidOnly.Location = new System.Drawing.Point(7, 41);
            this.SolidOnly.Name = "SolidOnly";
            this.SolidOnly.Size = new System.Drawing.Size(68, 16);
            this.SolidOnly.TabIndex = 7;
            this.SolidOnly.TabStop = true;
            this.SolidOnly.Text = "純色のみ";
            this.SolidOnly.UseVisualStyleBackColor = true;
            // 
            // SelectAll
            // 
            this.SelectAll.AutoSize = true;
            this.SelectAll.Location = new System.Drawing.Point(6, 18);
            this.SelectAll.Name = "SelectAll";
            this.SelectAll.Size = new System.Drawing.Size(74, 16);
            this.SelectAll.TabIndex = 6;
            this.SelectAll.TabStop = true;
            this.SelectAll.Text = "すべての色";
            this.SelectAll.UseVisualStyleBackColor = true;
            // 
            // SettingForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(279, 160);
            this.ControlBox = false;
            this.Controls.Add(this.CloseButton);
            this.Controls.Add(this.ColorSelectButton);
            this.Controls.Add(this.SampleText);
            this.Controls.Add(this.ScopeSelection);
            this.Controls.Add(this.ModeSelection);
            this.Name = "SettingForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "表示色選択";
            this.ModeSelection.ResumeLayout(false);
            this.ModeSelection.PerformLayout();
            this.ScopeSelection.ResumeLayout(false);
            this.ScopeSelection.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton FullColorOn;
        private System.Windows.Forms.GroupBox ModeSelection;
        private System.Windows.Forms.RadioButton FullColorOff;
        private System.Windows.Forms.Label SampleText;
        private System.Windows.Forms.Button ColorSelectButton;
        private System.Windows.Forms.Button CloseButton;
        private System.Windows.Forms.GroupBox ScopeSelection;
        private System.Windows.Forms.RadioButton SolidOnly;
        private System.Windows.Forms.RadioButton SelectAll;
    }
}