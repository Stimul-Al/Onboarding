import by.leverx.task_one.dto.TaskDto;
import by.leverx.task_one.mapper.TaskMapper;
import by.leverx.task_one.mapper.TaskMapperImpl;
import by.leverx.task_one.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import static util.Util.getTask;

public class MapperTest {

    private TaskMapper mapper;

    @BeforeEach
    void init() {
        mapper = new TaskMapperImpl();
    }

    @Test
    void checkMapper() {
        //given
        Task task = getTask().get(0);

        //when
        TaskDto dto = mapper.mapToDto(task);

        //then
        Assertions.assertEquals(task.getId(), dto.getId());
        Assertions.assertEquals(task.getTitle(), dto.getTitle());
        Assertions.assertEquals(task.getType(), dto.getType());
        Assertions.assertEquals(task.getTags(), dto.getTags());
    }
}
