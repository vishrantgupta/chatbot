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
package info.vishrantgupta.chatbot.conf;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;

/**
 * @author Vishrant Gupta
 *
 */
@Configuration
public class ChatbotConfig implements Cloneable, Serializable {

	private static final long serialVersionUID = -4426669207348680205L;
	
	private static volatile ChatbotConfig INSTANCE = new ChatbotConfig();

	private ChatbotConfig() {
	}

	public ChatbotConfig getInstance() {
		if (INSTANCE == null) {
			synchronized (ChatbotConfig.class) {
				if (INSTANCE == null) {
					INSTANCE = new ChatbotConfig();
				}
			}
		}
		return INSTANCE;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public Object readResolve() {
		return INSTANCE;
	}

}
