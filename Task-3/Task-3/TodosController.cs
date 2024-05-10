using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("api/[controller]")]
public class TodosController : ControllerBase
{
    private static List<TaskEntity> tasks = new List<TaskEntity>
    {
        new TaskEntity { Id = Guid.NewGuid(), Name = "Обновление системы безопасности", ShortDesc = "Установка последнего патча безопасности", FullDesc = "Необходимо загрузить и установить последнюю версию патча безопасности на все рабочие станции в офисе, чтобы предотвратить уязвимости.", Date = DateTime.Now, Status = false },
        new TaskEntity { Id = Guid.NewGuid(), Name = "Подготовка презентации", ShortDesc = "Презентация для клиента", FullDesc = "Подготовка подробной презентации с данными об эффективности проекта для встречи с новым потенциальным клиентом.", Date = DateTime.Now, Status = true },
        new TaskEntity { Id = Guid.NewGuid(), Name = "Проведение тренинга", ShortDesc = "Тренинг по использованию ПО", FullDesc = "Организовать тренинг для отдела продаж по новому программному обеспечению. Провести презентацию и дать ответы на вопросы сотрудников.", Date = DateTime.Now.AddDays(1), Status = false },
        new TaskEntity { Id = Guid.NewGuid(), Name = "Резервное копирование данных", ShortDesc = "Проверка резервного копирования", FullDesc = "Необходимо проверить и убедиться, что регулярное резервное копирование критически важных данных на сервере выполняется успешно.", Date = DateTime.Now.AddDays(3), Status = true }
    };

    [HttpGet]
    public ActionResult<IEnumerable<TaskEntity>> GetAll([FromQuery] int? limit, [FromQuery] int? offset)
    {
        var result = tasks.Skip(offset ?? 0).Take(limit ?? tasks.Count).ToList();
        return Ok(result);
    }

    [HttpGet("find")]
    public ActionResult<IEnumerable<TaskEntity>> FindByName([FromQuery] string q)
    {
        var result = tasks.Where(t => t.Name.Contains(q, StringComparison.OrdinalIgnoreCase)).ToList();
        return Ok(result);
    }

[HttpGet("date")]
    public ActionResult<IEnumerable<TaskEntity>> GetByDateRange([FromQuery] DateTime from, [FromQuery] DateTime to)
    {
        var result = tasks.ToList();
        return Ok(result);
    }

    [HttpPost]
    public IActionResult CreateTask([FromBody] TaskEntity task)
    {
        task.Id = Guid.NewGuid();
        tasks.Add(task);
        return CreatedAtAction(nameof(GetAll), new { id = task.Id }, task);
    }
}