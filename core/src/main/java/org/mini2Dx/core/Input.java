/*******************************************************************************
 * Copyright 2019 See AUTHORS file
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2Dx.core;

import org.mini2Dx.core.input.GamePad;
import org.mini2Dx.gdx.InputProcessor;
import org.mini2Dx.gdx.utils.Array;

public interface Input {
    /**
     * Sets the {@link InputProcessor} for handling mouse/keyboard/touch events
     * @param inputProcessor The {@link InputProcessor} to use
     */
    public void setInputProcessor(InputProcessor inputProcessor);

    /**
     * Returns the list of known {@link GamePad}s. If a {@link GamePad} disconnects/unplugs it will remain in this array.
     * @return An empty {@link Array} if no {@link GamePad}s are present.
     */
    public Array<GamePad> getGamePads();
}
