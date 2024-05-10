public class TaskEntity
{
    public Guid Id { get; set; }
    public string Name { get; set; }
    public string ShortDesc { get; set; }
    public string FullDesc { get; set; }
    public DateTime Date { get; set; }
    public bool Status { get; set; }
}