import by.leverx.dto.TaskDto;
import by.leverx.mapper.TaskMapper;
import by.leverx.mapper.TaskMapperImpl;
import by.leverx.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapperTest {

    private TaskMapper mapper;

    @BeforeEach
    void init() {
        mapper = new TaskMapperImpl();
    }

    @Test
    void checkMapper() {
        //given
        Task task = Util.getTask().get(0);

        //when
        TaskDto dto = mapper.mapToDto(task);

        //then
        Assertions.assertEquals(task.getId(), dto.getId());
        Assertions.assertEquals(task.getTitle(), dto.getTitle());
        Assertions.assertEquals(task.getType(), dto.getType());
        Assertions.assertEquals(task.getTags(), dto.getTags());
    }
}
