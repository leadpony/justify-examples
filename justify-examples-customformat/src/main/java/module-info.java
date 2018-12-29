module org.leadpony.justify.examples.customformat {
    requires org.leadpony.justify;
    provides org.leadpony.justify.spi.FormatAttribute 
        with org.leadpony.justify.examples.customformat.PalindromeFormatAttribute;
}
