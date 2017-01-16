/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.core.serialization.annotation.ConstructorArg;
import org.mini2Dx.core.serialization.annotation.Field;
import org.mini2Dx.core.serialization.annotation.PostDeserialize;
import org.mini2Dx.ui.layout.HorizontalAlignment;

/**
 * Utility implementation of {@link Button} that contains a {@link Label}
 */
public class TextButton extends Button {
	private Label label;
	
	@Field(optional=true)
	private String text = null;
	@Field(optional=true)
	private HorizontalAlignment textAlignment = HorizontalAlignment.CENTER;
	
	/**
	 * Constructor. Generates a unique ID for this {@link TextButton}
	 */
	public TextButton() {
		this(null);
	}
	
	/**
	 * Constructor
	 * @param id The unique ID for this {@link TextButton}
	 */
	public TextButton(@ConstructorArg(clazz=String.class, name = "id") String id) {
		super(id);
	}
	
	/**
	 * Called after XML/JSON deserialization
	 * Note: This method is for legacy support to 1.3.x
	 */
	@PostDeserialize
	public void postDeserialize() {
		checkInitialised();
		if(text != null) {
			label.setText(text);
		}
		if(textAlignment != null) {
			label.setHorizontalAlignment(textAlignment);
		}
	}
	
	private void checkInitialised() {
		if(label != null) {
			return;
		}
		for(int i = 0; i < children.size(); i++) {
			if(children.get(i) instanceof Label) {
				label = (Label) children.get(i);
				return;
			}
		}
		
		label = new Label(getId() + "-backingLabel");
		label.setHorizontalAlignment(HorizontalAlignment.CENTER);
		label.setResponsive(true);
		label.setVisibility(Visibility.VISIBLE);
		add(label);
	}
	
	/**
	 * Returns the text of this {@link TextButton}
	 * @return An empty {@link String} by default
	 */
	public String getText() {
		checkInitialised();
		return label.getText();
	}

	/**
	 * Sets the text of this {@link TextButton}
	 * @param text A non-null {@link String}
	 */
	public void setText(String text) {
		checkInitialised();
		label.setText(text);
		this.text = text;
	}

	/**
	 * Returns the {@link HorizontalAlignment} of the button's text
	 * @return {@link HorizontalAlignment#CENTER} by default
	 */
	public HorizontalAlignment getTextAlignment() {
		checkInitialised();
		return label.getHorizontalAlignment();
	}

	/**
	 * Sets the {@link HorizontalAlignment} of the button's text
	 * @param horizontalAlignment The text alignment
	 */
	public void setTextAlignment(HorizontalAlignment textAlignment) {
		checkInitialised();
		label.setHorizontalAlignment(textAlignment);
		this.textAlignment = textAlignment;
	}
}
