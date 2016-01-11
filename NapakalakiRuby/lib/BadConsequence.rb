#encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "TreasureKind.rb"
require_relative "Treasure.rb"
module NapakalakiGame
  class BadConsequence
    attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :tVisibleTreasures, :tHiddenTreasures
    def initialize(aText, someLevels = 0) 
      @text = aText
      @levels = someLevels
    end

    private_class_method :new
    
    def getText
      @text
    end
    
    def getLevels
      @levels
    end
    
    def to_s
      "#{@text}"
    end
    
  end
end