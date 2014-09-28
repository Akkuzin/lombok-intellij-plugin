// This is a generated file. Not intended for manual editing.
package de.plushnikov.intellij.plugin.language.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static de.plushnikov.intellij.plugin.language.psi.LombokConfigTypes.*;
import static de.plushnikov.intellij.plugin.language.psi.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LombokConfigParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("de.plushnikov.intellij.plugin.language.parser.LombokConfigParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == CLEANER) {
      result_ = cleaner(builder_, level_ + 1);
    }
    else if (root_ == OPERATION) {
      result_ = operation(builder_, level_ + 1);
    }
    else if (root_ == PROPERTY) {
      result_ = property(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      result_ = parse_root_(root_, builder_, level_);
      while (builder_.getTokenType() != null) {
        builder_.advanceLexer();
      }
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return simpleFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // (CLEAR KEY)
  public static boolean cleaner(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cleaner")) return false;
    return cleaner_0(builder_, level_ + 1);
  }

  // CLEAR KEY
  private static boolean cleaner_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "cleaner_0")) return false;
    if (!nextTokenIs(builder_, CLEAR)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, CLEAR, KEY);
    if (result_) {
      marker_.done(CLEANER);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // (property|cleaner|COMMENT|CRLF)
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    return item__0(builder_, level_ + 1);
  }

  // property|cleaner|COMMENT|CRLF
  private static boolean item__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item__0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = property(builder_, level_ + 1);
    if (!result_) result_ = cleaner(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // SIGN? SEPARATOR
  public static boolean operation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operation")) return false;
    if (!nextTokenIs(builder_, SEPARATOR) && !nextTokenIs(builder_, SIGN)
        && replaceVariants(builder_, 2, "<operation>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<operation>");
    result_ = operation_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEPARATOR);
    if (result_) {
      marker_.done(OPERATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // SIGN?
  private static boolean operation_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "operation_0")) return false;
    consumeToken(builder_, SIGN);
    return true;
  }

  /* ********************************************************** */
  // (KEY operation VALUE)
  public static boolean property(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property")) return false;
    return property_0(builder_, level_ + 1);
  }

  // KEY operation VALUE
  private static boolean property_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "property_0")) return false;
    if (!nextTokenIs(builder_, KEY)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, KEY);
    result_ = result_ && operation(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VALUE);
    if (result_) {
      marker_.done(PROPERTY);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simpleFile")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!item_(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "simpleFile");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

}
