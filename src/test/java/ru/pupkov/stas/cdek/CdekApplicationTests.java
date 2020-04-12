package ru.pupkov.stas.cdek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.pupkov.stas.cdek.domain.TaskForCalling;
import ru.pupkov.stas.cdek.repository.TasksRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CdekApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TasksRepository tasksRepository;

	@Test
	public void savingTask() throws Exception {
		int orderId = 123;
		Date orderCreationTime = getSqlDate("2020-01-01 09:00:00");
		Date taskAddingTime = getSqlDate("2021-01-01 19:00:00");
		boolean completed = false;

		when(tasksRepository.save(any())).thenReturn(new TaskForCalling(orderId, orderCreationTime, taskAddingTime, completed));
		mockMvc.perform(post("/tasks").contentType("application/json"));

		assertThat(tasksRepository.findById(orderId).toString().contains(orderCreationTime.toString()));
		assertThat(tasksRepository.findById(orderId).toString().contains(taskAddingTime.toString()));
		assertThat(tasksRepository.findById(orderId).toString().contains("false"));
	}

	@Test
	public void creatingTask() throws Exception {
		int orderId = 123123;
		Date orderCreationTime = getSqlDate("2020-01-01 09:00:00");
		Date taskAddingTime = getSqlDate("2021-01-01 19:00:00");
		boolean completed = true;

		TaskForCalling taskForCalling = new TaskForCalling(orderId, orderCreationTime, taskAddingTime, completed);

		assertThat(taskForCalling.getOrderId()).isEqualTo(orderId);
		assertThat(taskForCalling.getOrderCreationTime()).isEqualTo(orderCreationTime);
		assertThat(taskForCalling.getTaskAddingTime()).isEqualTo(taskAddingTime);
		assertThat(taskForCalling.isTaskIsCompleted()).isEqualTo(completed);
	}

	@Test
	public void filteringWithParameters() throws Exception {
		mockMvc.perform(get("/tasks")
				.param("dateStart", "2000-01-01")
				.param("dateFinish", "2020-01-01")
				.param("orderId", "000"))
				.andExpect(status().isOk());
	}

	@Test
	public void filteringWithoutParameters() throws Exception {
		mockMvc.perform(get("/tasks")).andExpect(status().isOk());
	}

	/** Полчуить из строки дату для БД */
	private Date getSqlDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Date sqlDate = new java.sql.Date(format.parse(date).getTime());
		return sqlDate;
	}
}
