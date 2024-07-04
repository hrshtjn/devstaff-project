package com.farmcollector.farmservice.controller;

import com.farmcollector.farmservice.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FarmService farmService;

    @Test
    public void testPlanted() throws Exception {
        String requestBody = "{\n" +
                "  \"name\": \"MyFarm2\",\n" +
                "  \"field\": {\n" +
                "    \"name\": \"Field1\"\n" +
                "  },\n" +
                "  \"crop\": {\n" +
                "    \"name\": \"Okra\"\n" +
                "  },\n" +
                "  \"season\": {\n" +
                "    \"name\": \"Spring2023\"\n" +
                "  },\n" +
                "  \"plantingArea\": 10,\n" +
                "  \"expectedProduct\": 20.0,\n" +
                "  \"actualProduct\": 0.0\n" +
                "}";

        this.mockMvc.perform(post("/api/planted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"name\": \"MyFarm2\",\n" +
                        "  \"field\": {\n" +
                        "    \"name\": \"Field1\"\n" +
                        "  },\n" +
                        "  \"crop\": {\n" +
                        "    \"name\": \"Okra\"\n" +
                        "  },\n" +
                        "  \"season\": {\n" +
                        "    \"name\": \"Spring2023\"\n" +
                        "  },\n" +
                        "  \"plantingArea\": 10,\n" +
                        "  \"expectedProduct\": 20.0,\n" +
                        "  \"actualProduct\": 0.0\n" +
                        "}"));
    }

    @Test
    public void testHarvested() throws Exception {
        String requestBody = "{\n" +
                "  \"name\": \"MyFarm2\",\n" +
                "  \"field\": {\n" +
                "    \"name\": \"Field1\"\n" +
                "  },\n" +
                "  \"crop\": {\n" +
                "    \"name\": \"Okra\"\n" +
                "  },\n" +
                "  \"season\": {\n" +
                "    \"name\": \"Spring2023\"\n" +
                "  },\n" +
                "  \"actualProduct\": 30.0\n" +
                "}\n";

        this.mockMvc.perform(post("/api/harvested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 35,\n" +
                        "    \"name\": \"MyFarm2\",\n" +
                        "    \"field\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"Field1\"\n" +
                        "    },\n" +
                        "    \"crop\": {\n" +
                        "        \"id\": 33,\n" +
                        "        \"name\": \"Okra\"\n" +
                        "    },\n" +
                        "    \"season\": {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"Spring2023\"\n" +
                        "    },\n" +
                        "    \"plantingArea\": 10.0,\n" +
                        "    \"expectedProduct\": 20.0,\n" +
                        "    \"actualProduct\": 30.0\n" +
                        "}"));
    }

    @Test
    public void testGetReportsByFarm() throws Exception {
        this.mockMvc.perform(get("/api/reports/farm")
                        .param("name", "MyFarm2")
                        .param("seasonName", "Summer2023"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testGetReportsByCropType() throws Exception {
        this.mockMvc.perform(get("/api/reports/crop")
                        .param("cropName", "Corn")
                        .param("seasonName", "Summer2023"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }





}
