/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.documentsui.dirlist;

import com.android.documentsui.base.DocumentInfo;
import com.android.documentsui.base.DocumentStack;

/**
 * Providers support for specializing the DirectoryFragment to the "host" Activity.
 * Feel free to expand the role of this class to handle other specializations.
 */
public abstract class FragmentTuner {

    // Subtly different from isDocumentEnabled. The reason may be illuminated as follows.
    // A folder is enabled such that it may be double clicked, even in settings
    // when the folder itself cannot be selected. This may also be true of container types.
    public boolean canSelectType(String docMimeType, int docFlags) {
        return true;
    }

    public boolean isDocumentEnabled(String docMimeType, int docFlags) {
        return true;
    }

    /**
     * When managed mode is enabled, active downloads will be visible in the UI.
     * Presumably this should only be true when in the downloads directory.
     */
    protected boolean managedModeEnabled() {
        return false;
    }

    /**
     * Whether drag n' drop is allowed in this context
     */
    protected boolean dragAndDropEnabled() {
        return false;
    }

    // TODO: Move to action handler.
    @Deprecated
    protected void showChooserForDoc(DocumentInfo doc) {
        throw new UnsupportedOperationException("Show chooser not supported!");
    }

    // TODO: Move to action handler.
    @Deprecated
    protected void openInNewWindow(DocumentStack stack, DocumentInfo doc) {
        throw new UnsupportedOperationException("Open in new window not supported!");
    }
}
