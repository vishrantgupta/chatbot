/*
 * Copyright (c) 2018 Vishrant Gupta <firstname.lastname@gmail.com>
 *
 * License: MIT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package info.vishrantgupta.chatbot.service;

import info.vishrantgupta.chatbot.db.entity.ChatbotData;
import info.vishrantgupta.chatbot.db.repository.ChatbotDataRepository;
import info.vishrantgupta.chatbot.mapper.ChatbotDataMapper;
import info.vishrantgupta.chatbot.model.AIMLModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vishrant Gupta
 *
 */

@Service
public class TrainingDataServiceImpl implements TrainingDataService {

	@Autowired
	private ChatbotDataRepository chatbotDataRepository;

	@Autowired
	private ChatbotDataMapper chatbotDataMapper;

	@Override
	public AIMLModel save(AIMLModel trainingData) {

		ChatbotData chatbotData = chatbotDataMapper
				.AIML2CassandraEntityMapper(trainingData);

		ChatbotData saved = chatbotDataRepository.save(chatbotData);

		AIMLModel aiml = chatbotDataMapper.CassandraEntity2AIMLMapper(saved);

		return aiml;
	}

}
