/*
 * Copyright 2010 Joachim Ansorg, mail@ansorg-it.com
 * File: BashRedirectListImpl.java, Class: BashRedirectListImpl
 * Last modified: 2010-05-09
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.expression;

import com.ansorgit.plugins.bash.lang.psi.BashVisitor;
import com.ansorgit.plugins.bash.lang.psi.api.expression.BashRedirectList;
import com.ansorgit.plugins.bash.lang.psi.impl.BashPsiElementImpl;
import com.ansorgit.plugins.bash.lang.psi.util.BashPsiUtils;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;

/**
 * User: jansorg
 * Date: Oct 29, 2009
 * Time: 8:51:31 PM
 */
public class BashRedirectListImpl extends BashPsiElementImpl implements BashRedirectList {
    public BashRedirectListImpl(final ASTNode astNode) {
        super(astNode, "BashRedirectList");
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        return BashPsiUtils.processChildDeclarations(this, processor, state, lastParent, place);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof BashVisitor) {
            ((BashVisitor) visitor).visitRedirectExpressionList(this);
        } else {
            visitor.visitElement(this);
        }
    }
}