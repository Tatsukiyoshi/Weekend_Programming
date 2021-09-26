namespace BlazorBmi
{
    public class BmiItem
    {
        public string? Name { get; set; }
        public double Height { get; set; }

        public double Weight { get; set; }
        public double Bmi
        {
            get => Height == 0 ? 0.0 : Weight / ((Height / 100.0) * (Height / 100.0));
        }
    }
}
