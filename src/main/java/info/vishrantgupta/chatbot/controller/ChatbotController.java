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
package info.vishrantgupta.chatbot.controller;

import info.vishrantgupta.chatbot.conf.ChatbotConfig;
import info.vishrantgupta.chatbot.model.AIMLModel;
import info.vishrantgupta.chatbot.service.TrainingDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishrant Gupta
 *
 */
@RestController
// @RequestMapping(value="/bot")
public class ChatbotController {

	@Autowired
	private ChatbotConfig chatbotConfig;

	@Autowired
	private TrainingDataService trainingDataService;

	@RequestMapping(value = "train")
	public void trainChatbot(
			@RequestParam(required = true, defaultValue = "{}") AIMLModel trainData) {

		if (trainData != null) {
			AIMLModel model = trainingDataService.save(trainData);
			
			
			
		}

	}

	@RequestMapping(value = "chat")
	public ResponseEntity<?> chat() {

		return ResponseEntity.ok("success");
	}

}
