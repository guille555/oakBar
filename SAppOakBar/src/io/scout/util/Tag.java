package io.scout.util;

/**
 * @author Guillermo, Gómez
 */
public enum Tag {

  TITLE {
    @Override
    public String toString() {
      return "OAk BAr";
    }
  },

  TITLE_SUCCESS {
    @Override
    public String toString() {
      return "Successful";
    }
  },

  TITLE_ERROR {
    @Override
    public String toString() {
      return "Error";
    }
  },

  TITLE_WARNING {
    @Override
    public String toString() {
      return "Warning";
    }
  },

  MESSAGE_OPERATION_SUCCESSFUL {
    @Override
    public String toString() {
      return "Operation successful";
    }
  },

  MESSAGE_OPERATION_FAILED {
    @Override
    public String toString() {
      return "Operation failed";
    }
  },

  MESSAGE_EMPTY_FIELD {
    @Override
    public String toString() {
      return "Empty field is not allowed";
    }
  },

  MESSAGE_SELECT_ROW {
    @Override
    public String toString() {
      return "You must select a row from the table";
    }
  },

  MESSAGE_QUESTION_ERASE {
    @Override
    public String toString() {
      return "Are you sure about erase the element?";
    }
  },

  TAG_ID {
    @Override
    public String toString() {
      return "ID";
    }
  },
}
