

module NapakalakiGame

  class Treasure
    attr_accessor :name, :bonus, :enum
    def initialize(name, bonus, enum)
      @name = name
      @bonus = bonus
      @enum = enum
    end

    def getName
      @name
    end

    def getBonus
      @bonus
    end

    def getType
      @enum
    end

    def to_s
      "Nombre: #{name}, Bonus: #{bonus}, Tipo: #{enum}"
    end

  end
end
